(ns advent-of-code.day25
  (:require [clojure.string :as str]))

(defn parse
  [input]
  (->> input
      str/split-lines
      (map #(Integer. %))))

(defn transform
  [subject-number value]
  (rem  (* value subject-number) 20201227))

(defn get-loops
  [key]
  (loop [value 1
         i 0]
    (if  (= value key)
      i
      (recur (transform 7 value) (inc i)))))

(defn get-key
  [subject-number i]
  (nth  (iterate (partial transform subject-number) 1) i))

(get-key 17807724 8)
