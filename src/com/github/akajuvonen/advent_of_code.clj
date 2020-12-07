(ns com.github.akajuvonen.advent-of-code
  (:gen-class))

(defn parse-file [filename]
  (let [arr (clojure.string/split (slurp filename) #"\n")]
    (map #(Integer/parseInt %) arr)))

(defn day1-part1 [entries]
  (loop [[entry & remaining] entries]
    (if-not (empty? remaining)
      (if (contains? entries (- 2020 entry))
        (* entry (- 2020 entry))
        (recur remaining)))))

(defn -main
  "Advent of code solutions main."
  [& args]
  (def entries (set (parse-file "inputs/day1.txt")))
  (println (day1-part1 entries)))
