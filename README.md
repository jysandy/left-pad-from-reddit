# left-pad

Writing your own code for left-padding a string is tedious and error-prone. This sort of systems programming is best left to experts, and most programmers would be better served by simply using a left-pad library. Unfortunately, the Clojure community hasn't realized the dangers of reinventing the wheel, so this library aims to remedy that.

However, writing ``` (left-pad "foo" 6)``` all over your code is boring and uninspiring. Don't you wish you could write
``` clojure
(id-just-like-to-interject-for-moment-what-youre-refering-to-as-linux-is-in-fact-gnulinux-or-as-ive-recently-taken-to-calling-it-gnu-plus-linux-linux-is-not-an-operating-system-unto-itself-but-rather-another-free-component-of-a-fully-functioning-gnu-system-made-useful-by-the-gnu-corelibs-shell-utilities-and-vital-system-components-comprising-a-full-os-as-defined-by-posix "foo" 6)
```
instead? Well, now you can!

## Usage

Use the `defn-from-reddit` macro to define your `left-pad` function. It takes a subreddit and a query map to select a post from the subreddit.

Example:

``` 
=> (defn-from-reddit "pcjcopypasta" {"id" "507jte"})
=> (what-the-fuck-did-you-just-fucking-say-about-me-you-pathetic-1xer-ill-have-you-know-i-got-offered-vc-funding-before-anyone-else-in-my-hackathon-and-ive-been-involved-in-numerous-kernel-contributor-flamewars-and-i-have-over-300-confirmed-commits-you-are-nothing-to-me-but-just-another-java-programmer-i-will-acquihire-your-company-and-fire-you-with-the-speed-of-an-18000-class-objective-c-app-mark-my-fucking-words-you-think-you-can-get-away-with-saying-that-shit-to-me-over-the-usergroup-forum-think-again-code-monkey-as-we-speak-i-am-contacting-my-secret-collective-of-fsf-freedom-fighters-and-your-proprietary-bug-ridden-shitware-is-being-hacked-right-now-so-you-better-prepare-for-the-storm-pleb-the-storm-that-wipes-out-the-pathetic-little-thing-you-call-your-github-repository-youre-fucking-out-of-a-job-kid-i-can-be-anywhere-anytime-and-i-can-buffer-overflow-your-software-with-over-seven-hundred-0-days-and-thats-just-with-my-vanilla-emacs-install-not-only-am-i-extensively-trained-in-webscale-deployments-but-i-have-access-to-the-entire-source-code-of-mongodb-and-i-will-use-it-to-its-full-potential-to-erase-your-linked-in-profile-off-the-face-of-the-internet-you-little-script-kiddie-if-only-you-could-have-known-what-unholy-retribution-your-little-clever-comment-was-about-to-bring-down-upon-your-docker-installation-maybe-you-would-have-held-your-fucking-tongue-but-you-couldnt-you-didnt-and-now-youre-paying-the-price-you-goddamn-enterprise-programmer "foo" 6)
;; "   foo"
```

