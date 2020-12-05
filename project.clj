(defproject com.github.akajuvonen/advent-of-code "0.1.0-SNAPSHOT"
  :description "Advent of Code 2020 solutions"
  :url "https://github.com/akajuvonen/advent-of-code-2020-clojure"
  :license {:name "MIT"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.10.1"]]
  :main ^:skip-aot com.github.akajuvonen.advent-of-code
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
