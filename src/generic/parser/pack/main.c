int getReloadValue(uint32_t reg)
{
    i2c_write_reg(0x23 , 0x56) ; 

    uint8_t val = 0 ;

    if(i2c_read_reg(0x23 , &val) == true )
    {
        print("val = %d",val) ;
        return val ;
    }
    
    else{
        return 0x00 ;
    }
}


void DumpI2c(){
    printf("DumpI2c") ;
}

struct {
    char * key ;
    void * value ;
}MAP_t;
