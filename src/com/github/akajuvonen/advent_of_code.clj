(ns com.github.akajuvonen.advent-of-code
  (:gen-class))

(defn parse-file [filename]
  (let [arr (clojure.string/split (slurp filename) #"\n")]
    (map #(Integer/parseInt %) arr)))

(defn day1-part1
  "Find the multiple of two entries that sum up to 2020"
  [entries]
  (loop [[entry & remaining] entries]
    (if-not (empty? remaining)
      (let [remainder (- 2020 entry)]
        (if (contains? entries remainder)
          (* entry remainder)
          (recur remaining))))))

(defn -main
  "Advent of code solutions main."
  [& args]
  (def entries (set (parse-file "inputs/day1.txt")))
  (println (day1-part1 entries)))
