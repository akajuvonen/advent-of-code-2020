(ns advent-of-code.day04
  (:require [clojure.string :as str]
            [clojure.walk :as walk]))

(defn separate-passports
  "Separate passport entries into their elements."
  [input]
  (-> input
      (slurp)
      (str/split #"\n\n")))

(defn separate-fields
  "Separate passport entries into their own elements."
  [input]
  (-> input
      (str/replace #"\n" " ")
      (str/split #" ")))

(defn fields->map
  "Parse a sequence of passport fields separated by : into a map."
  [fields]
  (->> fields
       (map #(str/split % #":"))
       (into {})
       (walk/keywordize-keys)))

(def required-keys [:byr :iyr :eyr :hgt :hcl :ecl :pid])

(defn validate-passport
  [passport-map]
  true)

(defn part1
  [input]
  (->> input
       (separate-passports)
       (map separate-fields)
       (map fields->map)
       (map #(every? % required-keys))
       (filter identity)
       (count)))

(defn part2
  [input]
  (->> input
       (separate-passports)
       (map separate-fields)
       (map fields->map)
       (map validate-passport)))
