(ns advent-of-code.day06
  (:require [clojure.string :as str]
            [clojure.set]))

(defn uniq-count
  "Calculate count of uniq chars in a sequence of strings."
  [s]
  (->> s
       (apply str)
       (set)
       (count)))

(defn common-chars
  "Identify common characters in a sequence of strings."
  [s]
  (->> s
       (map set)
       (apply clojure.set/intersection)))
(common-chars ["abc" "cde"])

(defn part1
  [input]
  (as-> input $
    (slurp $)
    (str/split $ #"\n\n")
    (map #(str/split % #"\n") $)
    (map uniq-count $)
    (reduce + $)))

(defn part2
  [input]
  (as-> input $
    (slurp $)
    (str/split $ #"\n\n")
    (map #(str/split % #"\n") $)
    (map common-chars $)
    (map count $)
    (reduce + $)))