lakilaki(alan).
lakilaki(mike).
lakilaki(john).
lakilaki(doni).
lakilaki(anton).
lakilaki(andre).

perempuan(diana).
perempuan(emi).
perempuan(silvi).
perempuan(melly).
perempuan(rossa).

ayah(doni,emi).
ayah(doni,andre).
ayah(mike,melly).
ayah(mike,anton).
ayah(mike,alan).
ayah(andre,rossa).
ayah(andre,john).
ibu(diana,emi).
ibu(diana,andre).
ibu(emi,melly).
ibu(emi,anton).
ibu(emi,alan).
ibu(silvi,rossa).
ibu(silvi,john).

anak(C,P):-ayah(P,C);ibu(P,C).
anaklakilaki(C,P):-anak(C,P),lakilaki(C).
anakperempuan(C,P):-anak(C,P),perempuan(C).

ortu(A,I,C):-ayah(A,C),ibu(I,C).
kakek(K,C):-ortu(A,I,C),(ayah(K,A);ayah(K,I)).
nenek(N,C):-ortu(A,I,C),(ibu(N,A);ibu(N,I)).

saudarakandung(B,C):-ortu(A,I,C),anak(B,A),anak(B,I),\+(B==C).
saudaraperempuan(B,C):-perempuan(B),saudarakandung(B,C).
saudaralakilaki(B,C):-lakilaki(B),saudarakandung(B,C).

grandortu(K,N,C):-kakek(K,C),nenek(N,C).
saudarasepupu(X,Y):-grandortu(K,N,Y),grandortu(K,N,X),\+(X==Y),\+saudarakandung(X,Y).

paman(P,C):-(saudarasepupu(SS,C),!),ortu(A,I,SS),P=A.
bibi(P,C):-(saudarasepupu(SS,C),!),ortu(A,I,SS),P=I.

pasangan(X,Y):-anak(C,X),anak(C,Y),\+(X==Y),!.
keponakan(K,X):-(pasangan(SP,X);SP=X),saudarakandung(SK,SP),anak(K,SK).
keponakanlakilaki(K,X):-keponakan(K,X),lakilaki(K).
keponakanperempuan(K,X):-keponakan(K,X),perempuan(K).

cucu(GC,G):-anak(C,G),anak(GC,C).
cuculaki(GC,G):-cucu(GC,G),lakilaki(GC).

suami(X,Y):-pasangan(X,Y),lakilaki(X).
istri(X,Y):-pasangan(X,Y),perempuan(X).