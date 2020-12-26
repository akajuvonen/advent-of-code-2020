(ns advent-of-code.day02
  (:require [clojure.string :as str]))

(defn parse-line
  [line]
  (let [[ints c passwd] (str/split line #" ")
        [first-int second-int] (map #(Integer. %) (str/split ints #"-"))
        c (first c)]
    [first-int second-int c passwd]))

(defn validate-passwd-count
  "Validate that character count in passwd is in range [lowest, highest]."
  [lowest 
   highest 
   character
   passwd]
  (as-> passwd $
    (frequencies $)
    (get $ character 0)
    (<= lowest $ highest)))
  
(defn validate-passwd-index
  [first-index
   second-index
   character
   passwd]
  (->> [first-index second-index]
       (map dec)
       (map #(nth passwd % nil))
       (map #(= % character))
       (filter identity)
       count
       (= 1)))

(defn validate-all-passwds
  [input
   validation-func]
  (->> input
       (str/split-lines)
       (map parse-line)
       (map #(apply validation-func %))
       (filter identity)
       count))
  
(defn part1
  [input]
  (validate-all-passwds (slurp input) validate-passwd-count))

(defn part2
  [input]
  (validate-all-passwds (slurp input) validate-passwd-index))
