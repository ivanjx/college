import cv2
import numpy as np

THRESHOLD = 128

def loadbiner(F):
    jum_baris, jum_kolom = F.shape
    G = np.zeros(F.shape, dtype=np.uint8)
    
    for baris in range(jum_baris):
        for kolom in range(jum_kolom):
            if F[baris, kolom] < THRESHOLD:
                G[baris, kolom] = 255

    return G


def tepibiner(F):
    jum_baris, jum_kolom = F.shape
    G = np.zeros(F.shape, dtype=np.uint8)

    for q in range(2, jum_baris - 1):
        for p in range(2, jum_kolom - 1):
            p0 = F[q, p+1]
            p1 = F[q-1, p+1]
            p2 = F[q-1, p]
            p3 = F[q-1, p-1]
            p4 = F[q, p-1]
            p5 = F[q+1, p-1]
            p6 = F[q+1, p]
            p7 = F[q+1, p+1]
            sigma = sum([p0, p1, p2, p3, p4, p5, p6, p7])
            if sigma == 8 * 255:
                G[q, p] = 0
            else:
                G[q, p] = F[q, p]

    return G


imgpath = str(input("Input: "))
img = cv2.imread(imgpath)
imgbin = loadbiner(cv2.imread(imgpath, cv2.IMREAD_GRAYSCALE))
imgtepi = tepibiner(imgbin)
cv2.imshow("Asli", img)
cv2.imshow("Biner", imgbin)
cv2.imshow("Tepi biner", imgtepi)
cv2.waitKey(0)