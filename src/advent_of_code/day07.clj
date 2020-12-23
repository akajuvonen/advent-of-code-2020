(ns advent-of-code.day07
  (:require [clojure.string :as str]))

(defn parse
  [input]
  (let [bag (second (re-find #"^(.*)\ bags\ contain" input))
        leftover-string (second (str/split input #"contain\ "))
        included-bag-strings (str/split leftover-string #",\ ")
        included-bag-colors (map second (map #(re-find #"\d\ (.*)\ " %) included-bag-strings))]
    [bag included-bag-colors]))

(parse "mirrored white bags contain 1 bright gray bag, 4 plaid blue bags.")
(parse "drab silver bags contain no other bags.")
