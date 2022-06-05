# Demo for overtone's issue [#486](https://github.com/overtone/overtone/issues/486) 
Loading sampled-piano fails on windows

# Reproducing the problem


1. start a supercollider server by hand, overtone can't do that on windows (see [official documentation](https://github.com/overtone/overtone/wiki/Connecting-scsynth#os-specific-setup))
2. run a repl: 
``` sh
lein repl
overtone-bug.core=> (boot-external-server)
overtone-bug.core=> (use 'overtone.inst.sampled-piano)
Syntax error (IOException) compiling at (piano.clj:23:1).
The system cannot find the path specified
```

The correct behavior should be to ask for credentials at freesound.org and download samples from freesound. Howver the paths that are created by overtone don't work on windows.

# Problems

1. [store.clj](https://github.com/overtone/overtone/blob/03 09c8d51f4480928af0bd49883e86fe67411c97/src/overtone/config/store.clj#L71) is using unix path separators
3. asset-path in [libs/asset.clj](https://github.com/overtone/overtone/blob/0309c8d51f4480928af0bd49883e86fe67411c97/src/overtone/libs/asset.clj#L101) tries to generate a path from an url with parameters. This path is invalid in windows and makes [canonical-path](https://github.com/overtone/overtone/blob/0309c8d51f4480928af0bd49883e86fe67411c97/src/overtone/helpers/file.clj#L121) throw an exception 
