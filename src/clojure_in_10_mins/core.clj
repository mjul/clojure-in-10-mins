(ns clojure-in-10-mins.core)

(println "Hello, World")

; This is a comment, semicolon is similar to // in C# / Java

;; Clojure has almost no syntax
;; Just a few data types

;; List is the most common data structure
'(1 2 3)

;; Vector is a list that is indexable by position
[1 2 3]

;; Maps are associative data structures
{:key "value", :id 42}

;; Sets are mathematical sets
#{1 2 3}

;; Expressions are list of the form (function arg-1 arg-2 ...)
(+ 1 2 3)

;; ----------------------------------------------------------------

;; Persistent data structures

(def a (list 1 2 3))
(def b (rest a))


