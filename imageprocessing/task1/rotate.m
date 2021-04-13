clc;
clear;
a = imread('gambar.jpg');
b = imrotate(a, 45);
subplot(1,2,1);
imshow(a);
subplot(1,2,2);
imshow(b);