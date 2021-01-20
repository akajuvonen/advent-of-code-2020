(ns advent-of-code.day16
  (:require [clojure.string :as str]))

(defn- parse-rules
  [list-of-rules]
  (let [parsed-rules (->> list-of-rules
                          (map #(str/split % #": "))
                          (map second)
                          (map #(str/split % #" or ")))]
    (set
     (flatten
      (for [rule-pair parsed-rules, rule rule-pair]
        (apply range
               (mapv
                #(Integer. %)
                (str/split rule #"-"))))))))

(defn- parse-nearby-tickets
  [nearby-tickets]
  (->> nearby-tickets
       str/split-lines
       rest
       (map #(str/split % #","))
       flatten
       (map #(Integer. %))))

(defn parse
  [input]
  (let [[rules _your-ticket nearby-tickets] (str/split input #"\n\n")
        rules (parse-rules (str/split-lines rules))
        nearby-tickets (parse-nearby-tickets nearby-tickets)]
    [rules nearby-tickets]))

(defn part1
  [input]
  (let [[rules nearby-tickets] (-> input slurp parse)]
    (reduce +
            (remove #(contains? rules %) nearby-tickets))))
