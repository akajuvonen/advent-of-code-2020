(ns advent-of-code.day22
  (:require [clojure.string :as str]))

(defn seq->intvec
  [l]
  (mapv #(Integer. %) l))

(defn parse
  [input]
  (as-> input i
    (str/split i #"\n\n")
    (map str/split-lines i)
    (map #(drop 1 %) i)
    (map #(seq->intvec %) i)))

(parse (slurp "inputs/day22.txt"))