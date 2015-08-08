(defproject intellij-custom-keymap-cheatsheet "0.1.0-SNAPSHOT"
  :description "Prints a CSV cheatsheet of customizations to an IntelliJ keymap"
  :url "https://github.com/halcyon/intellij-custom-keymap-cheatsheet"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]]
  :main ^:skip-aot intellij-custom-keymap-cheatsheet.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
