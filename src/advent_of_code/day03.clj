(ns advent-of-code.day03
  (:require [clojure.string :as str]
            [clojure.walk :as walk]))

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

(defn fields->map
  [fields]
  (->> fields
       (map #(str/split % #":"))
       (into {})
       (walk/keywordize-keys)))

(defn part1
  [input]
  (->> input
       (separate-passports)
       (map separate-fields)
       (map fields->map)))

(last (part1 "inputs/day03.txt"))
