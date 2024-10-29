# Esercizio di risoluzione di un merge conflict

**Il tempo massimo in laboratorio per questo esercizio è di _20 minuti_.
Se superato, sospendere l'esercizio e riprenderlo per ultimo!**

Si visiti https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.
Questo repository contiene due branch: `master` e `feature`

Per ognuna delle seguenti istruzioni, si annoti l'output ottenuto.
Prima di eseguire ogni operazione sul worktree o sul repository,
si verifichi lo stato del repository con `git status`.

1. Si cloni localmente il repository

cd ..
git clone https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.git

2. Ci si assicuri di avere localmente entrambi i branch remoti

git branch -a

3. Si faccia il merge di `feature` dentro `master`, ossia: si posizioni la `HEAD` su `master`
   e da qui si esegua il merge di `feature`

git checkout master
git merge origin/feature

4. Si noti che viene generato un **merge conflict**!

$ git merge origin/feature
Auto-merging HelloWorld.java
CONFLICT (content): Merge conflict in HelloWorld.java
Automatic merge failed; fix conflicts and then commit the result.

5. Si risolva il merge conflict come segue:
   - Il programma Java risultante deve stampare sia il numero di processori disponibili
     (funzionalità presente su `master`)
     che il nome dell'autore del file
     (funzionalità presente su `feature`)

git add HelloWorld.java
git commit -m "Merge finito"


6. Si crei un nuovo repository nel proprio github personale

cd ..
git clone https://github.com/zleo2404/ex1-06.git

7. Si aggiunga il nuovo repository creato come **remote** e si elenchino i remote

git remote add test https://github.com/zleo2404/ex1-06.git
git remote -v

8. Si faccia push del branch `master` sul proprio repository

git  push -u test master

9. Si setti il branch remoto `master` del nuovo repository come *upstream* per il proprio branch `master` locale

git branch --set-upstream-to=test/master
