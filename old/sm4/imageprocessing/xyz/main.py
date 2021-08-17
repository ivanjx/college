import cv2
import numpy as np


def rgb2xyz(I):
    K = [
        [0.49, 0.31, 0.2],
        [0.17697, 0.81240, 0.01063],
        [0, 0.01, 0.99],
    ]
    K = np.divide(K, 0.17697)

    I = I[..., ::-1] # bgr to rgb
    R = np.zeros(I.shape, dtype=np.float64)
    rows, cols, _ = I.shape
    
    for row in range(rows):
        for col in range(cols):
            RGB = I[row, col]
            RGB = np.reshape(RGB, (3, 1))
            XYZ = np.matmul(K, RGB)
            XYZ = np.divide(XYZ, 255)
            R[row, col] = XYZ.flatten()

    return R[..., ::-1] # xyz to zyx


def xyz2rgb(I):
    K = [
        [0.41847, -0.15866, -0.082835],
        [-0.091169, 0.25243, 0.015708],
        [0.00092090, 0.0025498, 0.17860],
    ]

    I = I[..., ::-1] # zyx to xyz
    R = np.zeros(I.shape, dtype=np.uint8)
    rows, cols, _ = I.shape

    for row in range(rows):
        for col in range(cols):
            XYZ = I[row, col]
            XYZ = np.multiply(XYZ, 255)
            XYZ = np.reshape(XYZ, (3, 1))
            RGB = np.matmul(K, XYZ)
            R[row, col] = RGB.flatten()

    return R[..., ::-1] # rgb to bgr


inpath = str(input("Input: ")).replace("\"", "")
I = cv2.imread(inpath)
Ixyz = rgb2xyz(I)
Irgb = xyz2rgb(Ixyz)
cv2.imshow("original", I)
cv2.imshow("xyz", Ixyz)
cv2.imshow("rgb", Irgb)
cv2.waitKey(0)
