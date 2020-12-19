(ns advent-of-code.day05)

(defn binary-space-partition
  [lower
   upper
   s
   lower-char]
  (if (nil? s)
    upper
    (let [[c & remaining] s
          diff (/ (- upper (dec lower)) 2)]
      (if (= c lower-char)
        (recur lower (- upper diff) remaining lower-char)
        (recur (+ lower diff) upper  remaining lower-char)))))

(defn get-row-and-column
  [s]
  (let [row-string (subs s 0 7)
        column-string (subs s 7 10)]
    (dec (binary-space-partition 1 128 row-string \F))))

(defn part1
  [input]
  (-> input
      (slurp)))
