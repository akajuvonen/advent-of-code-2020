(ns advent-of-code.day02
  (:require [clojure.string :as string]))

(defn validate-passwd
  "Validate that character count in passwd is in range [lowest, highest]. TODO: handle nill in freqs"
  [lowest 
   highest 
   character
   passwd]
  (<= lowest (get (frequencies passwd) character 0) highest))

(defn parse-line
  [line]
  (let [[low-high c passwd] (string/split line #" ")
        [low high] (map #(Integer. %) (string/split low-high #"-"))
        c (first c)]
    [low high c passwd]))

(defn part1
  [input]
  (count 
   (filter identity (map #(apply validate-passwd %) 
                         (map parse-line 
                              (string/split input #"\n"))))))
