(ns advent-of-code.day06
  (:require [clojure.string :as str]
            [clojure.set]))

(defn uniq-count
  "Calculate count of uniq chars in a sequence of strings."
  [s]
  (->> s
       (apply str)
       set
       count))

(defn common-chars
  "Identify common characters in a sequence of strings."
  [s]
  (->> s
       (map set)
       (apply clojure.set/intersection)))

(defn parse
  [input]
  (map #(str/split % #"\n")
       (str/split (slurp input) #"\n\n")))

(defn part1
  [input]
  (->> input
       parse
       (map uniq-count)
       (reduce +)))

(defn part2
  [input]
  (->> input
       parse
       (map common-chars)
       (map count)
       (reduce +)))
