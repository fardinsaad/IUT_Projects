[y,fs]=audioread('A1.wav');
[M,N]=size(y);
if N==2
    lc=y(:,1);
    rc=y(:,2);
    uvc=lc-rc;
    %audiowrite('resu.wav',uvc,fs);  
    n=fft(uvc);
    x=n;
    j=1 ;
 
   for j=1:20
    for i=int64((200*j*M)/fs):int64((250*j*M)/fs)-1
      
       x(i)=0;
       
   end    
    for i=M-int64((250*j*M)/fs):M-int64((200*j*M)/fs)+1
      
       x(i)=0;
       
    end 
  
  end  
   audiowrite('resrv.wav',ifft(x),fs);
   subplot(2,1,1);
   plot(abs(n));
   subplot(2,1,2)
   plot(abs(abs(x)));


else
    error('size not compatible');
end;     