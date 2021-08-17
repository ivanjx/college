clc;
clear;
a = imread('gambar.jpg');
b = imcrop(a, [0 0 2000 2000]);
subplot(1,2,1);
imshow(a);
subplot(1,2,2);
imshow(b);