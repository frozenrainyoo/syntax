//
//  Student.m
//  test
//
//  Copyright © 2019 frozenrainyoo. All rights reserved.
//

#import "Student.h"

@implementation Student

-(void)study {
    NSLog(@"Study");
}

@end

@implementation Student (Enrollement)

-(void)enroll {
    NSLog(@"enroll");
}

@end
