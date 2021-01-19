(ns advent-of-code.day22
  (:require [clojure.string :as str]))

(defn seq->intvec
  [l]
  (mapv #(Integer. %) l))

(defn parse
  [input]
  (let [split (str/split input #"\n\n")]
    (->> split
     (map str/split-lines)
     (map #(drop 1 %))
     (map #(seq->intvec %)))))

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
  (calculate-score (play-game deck1 deck2)))
