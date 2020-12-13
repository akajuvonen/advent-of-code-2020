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
  (let [[ints c passwd] (string/split line #" ")
        [first-int second-int] (map #(Integer. %) (string/split ints #"-"))
        c (first c)]
    [first-int second-int c passwd]))

(defn part1
  [input]
  (count 
   (filter identity (map #(apply validate-passwd %) 
                         (map parse-line 
                              (string/split input #"\n"))))))

(nth [1 2 3] 4 nil)