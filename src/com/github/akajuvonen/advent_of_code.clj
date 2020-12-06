(ns com.github.akajuvonen.advent-of-code
  (:gen-class))

(defn parse-file [filename]
  (let [arr (clojure.string/split (slurp filename) #"\n")]
    (map #(Integer/parseInt %) arr)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (parse-file "inputs/day1.txt")))
