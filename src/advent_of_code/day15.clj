(ns advent-of-code.day15)

(defn memory-game
  [initial-map n]
  (loop [numbers initial-map
         turn (inc (count initial-map))
         last-number 6]
    (if (> turn n)
      last-number
      (if-let [last-spoken (get numbers last-number)]
        (let [turns-apart (- (dec turn) last-spoken)]
          (recur (assoc numbers last-number (dec turn))
                 (inc turn)
                 turns-apart))
        (recur (assoc numbers last-number (dec turn))
               (inc turn)
               0)))))

(comment
  (let [initial (into {} (map vector [0 3 6] (range 1 4)))]
    (memory-game initial 10)))
