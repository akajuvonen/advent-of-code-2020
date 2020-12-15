(ns advent-of-code.day03
  (:require [clojure.string :as str]
            [clojure.walk :only keywordize-keys]))

(defn separate-passports
  "Separate passport entries into their elements."
  [input]
  (as-> input $
      (slurp $)
      (str/split  $ #"\n\n")))

(defn separate-fields
  "Separate passport entries into their own elements."
  [input]
  (-> input
      (str/replace #"\n" " ")
      (str/split #" ")))

(defn vec->map
  [vector]
  (->> vector
       (map #(str/split % #":"))
       (into {})))

(defn part1
  [input]
  (-> input
      (separate-passports)
      (first)
      (separate-fields)
      (vec->map)))

(part1 "inputs/day03.txt")
