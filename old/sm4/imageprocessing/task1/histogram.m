clc;
clear;
a = imread('gambar.jpg');
red = a(:,:,1);
green = a(:,:,2);
blue = a(:,:,3);
hred = imhist(red);
hgreen = imhist(green);
hblue = imhist(blue);
range = 0:255;
subplot(1,2,1);
imshow(a);
subplot(1,2,2);
plot(range, hred, 'Color', 'Red');
hold on
plot(range, hgreen, 'Color', 'Green');
hold on
plot(range, hblue, 'Color', 'Blue');