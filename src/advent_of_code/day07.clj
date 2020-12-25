(ns advent-of-code.day07
  (:require [clojure.string :as str]))

(defn parse
  "Parse an input text file of bag colors into structure like
   [parent-color [child-color1, ...], ...]"
  [input]
  (let [bag (second (re-find #"^(.*)\ bags\ contain" input))
        leftover-string (second (str/split input #"contain\ "))
        included-bag-strings (str/split leftover-string #",\ ")
        included-bag-colors (map second (map #(re-find #"\d\ (.*)\ " %) included-bag-strings))]
    [bag included-bag-colors]))

(defn- bag-map
  "Convert a sequence of [bag-color [child bag colors]] into a map {child [parent]}.
   Children may be nil."
  [[parent children]]
  (map #(hash-map % [parent]) children))

(defn bag-maps
  "Convert a sequence of [bag/list of child bags] pairs into map
   of bags and its parents. E.g.,
   {bag-color [parent-color1 parent-color2], ...}"
  [bags]
  (->> bags
    (map bag-map)
    (flatten)
    (apply merge-with into)
    (remove (comp nil? first))
    (into {})))

(defn part1
  [input]
  (as-> input i
    (slurp i)
    (str/split i #"\n")
    (map parse i)
    (bag-maps i)))

(part1 "inputs/day07.txt")
