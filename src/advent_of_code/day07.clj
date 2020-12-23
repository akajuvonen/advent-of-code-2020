(ns advent-of-code.day07)

(defn parse
  [input]
  (let [bag (second (re-find #"^(.*)\ bags\ contain" input))]
    bag))

(parse "mirrored white bags contain 1 bright gray bag, 4 plaid blue bags.")
