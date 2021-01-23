(ns advent-of-code.day25
  (:require [clojure.string :as str]))

(defn parse
  [input]
  (->> input
      str/split-lines
      (map #(Integer. %))))

(defn transform
  [value subject-number]
  (rem  (* value subject-number) 20201227))

(defn get-loops
  [key]
  (loop [value 1
         i 0]
    (if  (= value key)
      i
      (recur (transform value 7) (inc i)))))

(let [[door card] (parse (slurp "inputs/day25.txt"))]
  (get-loops door))

(get-loops 5764801)
