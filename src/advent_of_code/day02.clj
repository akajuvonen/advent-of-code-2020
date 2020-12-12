(ns advent-of-code.day02
  (:require [clojure.string :as string]))

(defn validate-passwd
  "Validate that character count in passwd is in range [lowest, highest]"
  [lowest 
   highest 
   character
   passwd]
  (<= lowest (get (frequencies passwd) character) highest))

(defn parse-line
  [line]
  (println line)
  (let [[low-high c passwd] (string/split line #" ")
        [low high] (map #(Integer. %) (string/split low-high #"-"))
        c (first c)]
    [low high c passwd]))

(defn part1
  [input]
  (count 
   (map #(apply validate-passwd %) 
        (map parse-line 
             (string/split input #"\n")))))


