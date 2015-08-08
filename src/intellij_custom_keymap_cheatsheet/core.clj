(ns intellij-custom-keymap-cheatsheet.core
  (:require [clojure.string :as str]
            [clojure.xml :as xml])
  (:gen-class))

(defn render-shortcut [shortcut]
  (when (seq shortcut)
    (->> (str/split shortcut #" ")
         (map #(get {"shift"         "\u21E7"
                     "meta"          "\u2318"
                     "option"        "\u2325"
                     "alt"           "\u2325"
                     "control"       "⌃"
                     "RIGHT"         "→"
                     "LEFT"          "←"
                     "BACK_SLASH"    "\\"
                     "ENTER"         "↵"
                     "DOWN"          "↓"
                     "UP"            "↑"
                     "QUOTE"         "'"
                     "SEMICOLON"     ";"
                     "OPEN_BRACKET"  "["
                     "CLOSE_BRACKET" "]"
                     "BACK_SPACE"    "⌫"
                     "PERIOD"        "."
                     "COMMA"         ","
                     } % %))
         (str/join ""))))

(defn print-keymap [file]
  (let [bindings (:content (xml/parse file))]
    (->> (for [{:keys [attrs content]} bindings
               :let [fst (render-shortcut (:first-keystroke (:attrs
                                                              (first content))))
                     snd (render-shortcut (:second-keystroke (:attrs
                                                               (first content))))]
               :when fst]
           (format "\"%s\",\"%s\",\"%s\"" fst (or snd "") (:id attrs)))
         (map println)
         (dorun))))

(defn -main
  [& args]
  (print-keymap (first args)))