(ns overtone-bug.core
  (:require [overtone.core :refer :all])
  )

(comment
  ;; start supercollider and launch a server,
  ;; overtone can't do it by itself
  ;;
  ;; start a repl and paste this
  (boot-external-server)

  ;; this would work
  ;;   (use 'overtone.inst.piano)
  ;;   (piano 60)

  (use 'overtone.inst.sampled-piano)
  ;; Syntax error (IOException) compiling at (piano.clj:23:1).
  ;; The system cannot find the path specified
  )
