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

(defn validate-required-fields
  "Check that all required fields are in a map."
  [fields]
   (every? fields required-keys))

(defn validate-digits
  "Validate that a string contains n digits and is between min and max."
  [n min max s]
  (and
   (re-matches (re-pattern (str "\\d{" n "}")) s)
   (<= min (Integer. s) max)))

(defn validate-height
  "Validate passport height."
  [s]
  (or
   (and (re-matches #"\d{3}cm" s) (<= 150 (Integer. (subs s 0 3)) 193))
   (and (re-matches #"\d{2}in" s) (<= 59 (Integer. (subs s 0 2)) 76))))

(defn validate-color
  "Check that s is # followed by 6 characters [a-z] or [0-9]"
  [s]
  (re-matches #"#[a-z0-9]{6}" s))

(defn validate-passport
  [passport-map]
  (and (validate-required-fields passport-map)
       (validate-digits 4 1920 2002 (:byr passport-map))
       (validate-digits 4 2010 2020 (:iyr passport-map))
       (validate-digits 4 2020 2030 (:eyr passport-map))
       (validate-height (:hgt passport-map))
       (validate-color (:hcl passport-map))
       (contains? #{"amb" "blu" "brn" "gry" "grn" "hzl" "oth"} (:ecl passport-map))
       (re-matches #"\d{9}" (:pid passport-map))
       ))

(defn part1
  [input]
  (->> input
       (separate-passports)
       (map separate-fields)
       (map fields->map)
       (map validate-required-fields)
       (filter identity)
       (count)))

(defn part2
  [input]
  (->> input
       (separate-passports)
       (map separate-fields)
       (map fields->map)
       (map validate-passport)
       (filter identity)
       (count)))
