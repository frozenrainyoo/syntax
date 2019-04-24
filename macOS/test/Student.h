//
//  Student.h
//  test
//
//  Copyright © 2019 frozenrainyoo. All rights reserved.
//

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface Student : NSObject

-(void)study;

@end

@interface Student (Enrollment)

-(void)enroll;

@end

NS_ASSUME_NONNULL_END
