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

(defn play-game
  [deck1 deck2]
  (if (empty? deck2)
    deck1
    (if (empty? deck1)
      deck2
      (let [card1 (first deck1)
            card2 (first deck2)]
        (if (> card1 card2)
          (recur (conj  (subvec deck1 1) card1 card2) (subvec deck2 1))
          (recur (subvec deck1 1) (conj  (subvec deck2 1) card2 card1)))))))

(defn calculate-score
  [deck]
  (reduce + (map #(reduce * %)
                 (map vector deck (range (count deck) 0 -1)))))

(let [[deck1 deck2] (parse (slurp "inputs/day22.txt"))]
  (play-game deck1 deck2))
