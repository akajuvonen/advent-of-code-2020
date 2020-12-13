(ns advent-of-code.day02
  (:require [clojure.string :as string]))

(defn parse-line
  [line]
  (let [[ints c passwd] (string/split line #" ")
        [first-int second-int] (map #(Integer. %) (string/split ints #"-"))
        c (first c)]
    [first-int second-int c passwd]))

(defn validate-passwd-count
  "Validate that character count in passwd is in range [lowest, highest]."
  [lowest 
   highest 
   character
   passwd]
  (<= lowest (get (frequencies passwd) character 0) highest))

(defn validate-passwd-index
  [first-index
   second-index
   character
   passwd]
  (= 1 
     (count 
      (filter identity 
              (map #(= % character)
                   (map #(nth passwd % nil)
                        (into []
                              (map dec [first-index second-index]))))))))

(defn part1
  [input]
  (count 
   (filter identity (map #(apply validate-passwd-count %) 
                         (map parse-line 
                              (string/split input #"\n"))))))

