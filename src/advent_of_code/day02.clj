(ns advent-of-code.day02
  (:require [clojure.string :as string]))

(defn get-char-freq 
  [passwd char]
  (let [freq (get (frequencies passwd) char)]
    (if (nil? freq) 0 freq)))

(defn validate-passwd
  "Validate that character count in passwd is in range [lowest, highest]. TODO: handle nill in freqs"
  [lowest 
   highest 
   character
   passwd]
  (<= lowest (get-char-freq passwd character) highest))

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
