clc;
clear;
rgb = imread('gambar.jpg');
i = rgb2gray(rgb);
subplot(1,2,1);
imshow(rgb);
subplot(1,2,2);
imshow(i);