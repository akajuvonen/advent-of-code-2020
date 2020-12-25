(ns advent-of-code.day07
  (:require [clojure.string :as str]))

(defn parse
  [input]
  (let [bag (second (re-find #"^(.*)\ bags\ contain" input))
        leftover-string (second (str/split input #"contain\ "))
        included-bag-strings (str/split leftover-string #",\ ")
        included-bag-colors (map second (map #(re-find #"\d\ (.*)\ " %) included-bag-strings))]
    [bag included-bag-colors]))

(defn- bag-map
  "Convert a sequence of [bag/list of child bags] into a map {child [parent]}"
  [[parent children]]
  (map #(hash-map % [parent]) children))

(defn bag-maps
  "Convert a sequence of [bag/list of child bags] pairs into map of bags and its parents."
  [bags]
  (as-> bags b
    (map bag-map b)
    (flatten b)))

(defn part1
  [input]
  (as-> input i
    (slurp i)
    (str/split i #"\n")
    (map parse i)
    (bag-maps i)))

(part1 "inputs/day07.txt")
