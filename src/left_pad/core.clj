(ns left-pad.core
  (:gen-class)
  (:require [org.httpkit.client :as http]
            [cheshire.core :as cheshire]
            [clojure.string :as s]))

(defn match-query
  "Checks if the data satisfies the given query, that is, 
  whether the key-value pairs in query are all present in data."
  [query data]
  (= query (select-keys data (keys query))))

(defn fetch-from-subreddit
  "Fetches entries from the sub that match the query.
  The query is just a map with values, mirroring the
  structure returned by Reddit. "
  [subreddit query]
  (let [response (http/get (format "https://reddit.com/r/%s.json"
                                   subreddit))
        data (cheshire/parse-string (:body @response))] 
    (->> (get-in data ["data" "children"])
         (map #(get % "data"))
         (filter (partial match-query query)))))

(defn clean-string
  "Cleans a string, making it fit for turning into a symbol."
  [string]
  (-> string
      (#(first (s/split % #"\n\n")))
      (s/trim)
      (s/replace #"[^A-z0-9-\s]" "")
      (s/replace #"\s" "-")
      (s/lower-case)))

(defmacro defexp
  "def with an expression that returns a string"
  [exp value]
  `(def ~(symbol (eval exp)) ~value))

(defn left-pad
  "Proprietary core business logic"
  ([string length] (left-pad string length " "))
  ([string length pad-value]
   (str (apply str (repeat (- length (count string)) pad-value))
        string)))

(defmacro defn-from-reddit
  [subreddit query]
  (let [string# (-> (first (fetch-from-subreddit subreddit query))
                    (#(get % "selftext"))
                    (clean-string))]
    `(defexp ~string# left-pad)))
