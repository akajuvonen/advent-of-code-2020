(ns advent-of-code.day25
  (:require [clojure.string :as str]))

(defn parse
  [input]
  (->> input
      str/split-lines
      (map #(Integer. %))))

(defn transform
  [value]
  (rem  (* value 7) 20201227))

(let [[door card] (parse (slurp "inputs/day25.txt"))]
  [door card])