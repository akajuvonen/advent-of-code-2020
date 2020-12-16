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

(defn part1
  [input]
  (->> input
       (separate-passports)
       (map separate-fields)
       (map fields->map)
       (map #(every? % required-keys))
       (filter identity)
       (count)))

(let [m {:hcl "#a7a05c", :pid "0137262572", :eyr "2023", :cid "350", :iyr "2015", :ecl "#52d3fe", :hgt "190cm", :byr "2007"}]
  (every? m required-keys))