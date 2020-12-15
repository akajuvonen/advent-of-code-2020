(ns advent-of-code.day03
  (:require [clojure.string :as str]))

(defn separate-passports
  "Separate passport entries into their elements."
  [input]
  (as-> input $
      (slurp $)
      (str/split  $ #"\n\n")))

(defn part1
  [input]
  (separate-passports input))

(part1 "inputs/day03.txt")
