(ns advent-of-code.day22
  (:require [clojure.string :as str]))

(defn- seq->intvec
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
  "Play a game where one card is drawn from both decks. Player with larger
   number gets both added to his/her deck. Player wins when other player's
   deck is empty."
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
  "Calculate deck's score. E.g., deck is [4 5 6], score is
   3 * 4 + 2 * 5 + 1 * 6."
  [deck]
  (reduce + (map #(reduce * %)
                 (map vector deck (range (count deck) 0 -1)))))

(defn part1
  [input]
  (let [[deck1 deck2] (parse (slurp input))]
    (calculate-score (play-game deck1 deck2))))
