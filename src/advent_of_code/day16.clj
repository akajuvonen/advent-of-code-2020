(ns advent-of-code.day16
  (:require [clojure.string :as str]))

(defn- parse-rules
  [list-of-rules]
  (let [parsed-rules (->> list-of-rules
                          (map #(str/split % #": "))
                          (map second)
                          (map #(str/split % #" or ")))]
    (for [rule-pair parsed-rules, rule rule-pair]
      (map #(Integer. %) (str/split rule #"-")))))

(defn parse
  [input]
  (let [[rules your-ticket nearby-tickets] (str/split input #"\n\n")
        rules (parse-rules (str/split-lines rules))]
    rules))

(let [input (slurp "inputs/day16.txt")]
  (-> input
      parse))