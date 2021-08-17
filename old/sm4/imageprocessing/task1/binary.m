clc;
clear;
rgb = imread('gambar.jpg');
i = im2bw(rgb);
subplot(1,2,1);
imshow(rgb);
subplot(1,2,2);
imshow(i);