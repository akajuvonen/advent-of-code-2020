(ns advent-of-code.day06
  (:require [clojure.string :as str]))

(defn uniq-count
  "Calculate count of uniq chars in a sequence of strings."
  [l]
  (->> l
       (apply str)
       (set)
       (count)))

(defn part1
  [input]
  (as-> input $
    (slurp $)
    (str/split $ #"\n\n")
    (map #(str/split % #"\n") $)
    (map uniq-count $)
    (reduce + $)))
